#!/bin/sh
# 应用名
APP=$1
# 环境
ENV=$2

./stop.sh $APP $ENV

./start.sh $APP $ENV
