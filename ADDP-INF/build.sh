#!/bin/sh
# 应用名
APP=$1
# 环境
ENV=$2
# 应用端口
port=$3
# 寻找打包的jar包，移动到当前目录
jar=$(find ./ -name ${APP}-start*.jar)
cp ${jar} ./ADDP-INF/${APP}.jar
#build_app_image() {
#    IMAGE="$(docker images|grep ${APP})"
#    if [ -n ${IMAGE} ]
#    then
#        echo "start build base image..."
#        docker build -t ${APP}:${ENV}   --build-arg APP_NAME=${APP} --build-arg ENV=${ENV} -f ./ADDP-INF/Dockerfile ./ADDP-INF
#    else
#        docker rm ${APP}:${ENV}
#    fi
#}
docker rmi ${APP}:${ENV}
docker build -t ${APP}:${ENV}   --build-arg APP_NAME=${APP} --build-arg ENV=${ENV} -f ./ADDP-INF/Dockerfile ./ADDP-INF
