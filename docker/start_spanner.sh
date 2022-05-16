#!/bin/bash

set -m
gcloud components update
gcloud emulators spanner start &

gcloud config set auth/disable_credentials true
gcloud config set project spanner-emulator
gcloud config set api_endpoint_overrides/spanner http://localhost:9020/
gcloud config configurations activate spanner-emulator

gcloud spanner instances create spanner-emulator-instance \
  --config=emulator-config \
  --description="Spanner Emulator Instance" \
  --nodes=1

gcloud spanner databases create spanner-db \
 --instance=spanner-emulator-instance

# Create a test table
gcloud spanner databases ddl update spanner-db --instance=spanner-emulator-instance --ddl='CREATE TABLE test (userId STRING(36) NOT NULL, businessEmail STRING(50), fullName STRING(36), password STRING(100), photoUrl STRING(250), provider STRING(20),
forceChangePassword BOOL) PRIMARY KEY(userId);
CREATE UNIQUE NULL_FILTERED INDEX usersByBusinessEmail ON users (businessEmail);'

fg %1