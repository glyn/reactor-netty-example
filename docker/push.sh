#!/usr/bin/env bash

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

cp ${SCRIPT_DIR}/../build/libs/reactor-netty-example.jar ${SCRIPT_DIR}/server/.
cp ${SCRIPT_DIR}/../dependencies/* ${SCRIPT_DIR}/server/dependencies
