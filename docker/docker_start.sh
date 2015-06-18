#!/bin/bash
#
# Copyright 2015 Red Hat, Inc. and/or its affiliates
# and other contributors as indicated by the @author tags.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

if [ -z ${AUTH_KEY} ]; then
   echo "Missing SauceLabs AUTH_KEY env"
   exit 1
fi

#printf "1=firefox:24.0:Linux" > ${WORKING_DIR}/src/test/resources/browserAndOs.properties
OPTS="-DhawkularUrl=${HAWKULAR_ENDPOINT:-http://localhost:8080} -DauthenticationKey=${AUTH_KEY}"
hawkular_wait.sh && mvn -f ${WORKING_DIR}  -o test ${OPTS}

chmod +x -R /reports

echo "## Test completed ##"
while true; do sleep 5; done
