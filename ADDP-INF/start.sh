#!/bin/sh
# 应用名
APP=$1
# 环境
ENV=$2
# 应用端口
port=$3

# 启动应用镜像
#container="$(docker ps -a |grep ${APP}-${ENV})"
#if [ -z ${container} ]
#    then
#        echo "build container"
#
#     else
#        docker start ${APP}-${ENV}
#fi

docker stop ${APP}-${ENV}
docker rm ${APP}-${ENV}
docker run  --name ${APP}-${ENV}  -p ${port}:80 -v /tmp:/tmp -dit ${APP}:${ENV}
