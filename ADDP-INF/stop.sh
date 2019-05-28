#!/bin/sh
# 应用名
APP=$1
# 环境
ENV=$2

docker stop ${APP}-${ENV}
