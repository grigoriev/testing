#!/usr/bin/env bash

pushd "$(dirname $0)/.." > /dev/null

jmh_result_json_files=$(find . -name "jmh-result.json" -print)
jq -s add ${jmh_result_json_files} > jmh-aggregated-results.json

popd > /dev/null
