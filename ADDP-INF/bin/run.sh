#!/bin/sh
# 等到jar包
jar=$(ls ./|grep \\.name)
env=$(ls ./|grep \\.env)
echo $jar
# 等到项目名
APP=$(echo ${jar%.name*})
env=$(echo ${env%.env*})
# 启动命令
echo $APP
java -jar /home/admin/${APP}/${APP}.jar --spring.profiles.active=${env}

#tail -f /tmp/${APP}.log
