#!/usr/bin/env bash
cd /usr/local/AllDemo/
echo "拉取最新代码"
git pull
cd demo2-usermanager
echo "编译打包项目"
mvn clean install package

echo "检查现有进程是否启动，并进行停止"
pid=$(ps x | grep "demo2-usermanager-1.0.jar" | grep -v grep | awk '{print $1}')
if [ -n "$pid" ]; then
echo "存在对应进程，正在停止"
kill -9 $pid
sleep 2s
fi

echo "拷贝jar包"
cd /usr/local/demo2-usermanager-deploy/
\cp -rf /usr/local/AllDemo/demo2-usermanager/target/demo2-usermanager-1.0.jar /usr/local/demo2-usermanager-deploy/
echo "启动jar包"
nohup java -jar demo2-usermanager-1.0.jar >/dev/null 2>&1 &
echo "查看服务器启动日志"
tailf /usr/local/demo2-usermanager-deploy/logs/spring.log
