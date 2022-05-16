#!/usr/bin/env bash

gcloud components update

# Starts Docker container for Spanner Emulator
gcloud emulators spanner start &

gcloud config configurations create emulator
gcloud config set auth/disable_credentials true
gcloud config set project test-project
gcloud config set api_endpoint_overrides/spanner http://localhost:9020/
gcloud config configurations activate default
gcloud config configurations activate emulator

# Confirm the configurations
gcloud config list
gcloud spanner instance-configs list

# Create Spanner instance
gcloud spanner instances create test-instance --config=emulator-config \
--description="Test Instance - Cloud Spanner emulator" --nodes=3

# Confirm the instance created
gcloud spanner instances list

# Create a database
gcloud spanner databases create test-database --instance test-instance

# Create a table
gcloud spanner databases ddl update test-database --instance=test-instance --ddl='CREATE TABLE users (userId STRING(36) NOT NULL, businessEmail STRING(50), fullName STRING(36), password STRING(100), photoUrl STRING(250), provider STRING(20),
forceChangePassword BOOL) PRIMARY KEY(userId);
CREATE UNIQUE NULL_FILTERED INDEX usersByBusinessEmail ON users (businessEmail);'

# Verify tables created
gcloud spanner databases execute-sql test-database --instance=test-instance --sql='SELECT * FROM information_schema.tables WHERE table_schema <> "INFORMATION_SCHEMA"'

# Select from the table
gcloud spanner databases execute-sql test-database --instance=test-instance  --sql='SELECT * FROM users'