#!/usr/bin/env bash
cd /root/AllDemo/
echo "拉取最新代码"
git pull
cd /root/AllDemo/demo1-helloworld
echo "编译打包项目"
mvn clean install package

echo "检查现有进程是否启动，并进行停止"
pid=$(ps x | grep "demo1-helloworld-0.0.1-SNAPSHOT.jar" | grep -v grep | awk '{print $1}')
if [ -n "$pid" ]; then
echo "存在对应进程，正在停止"
kill -9 $pid
sleep 2s
fi

echo "拷贝jar包"
cd /root/demo1-helloworld-deploy/
\cp -rf /root/AllDemo/demo1-helloworld/target/demo1-helloworld-0.0.1-SNAPSHOT.jar /root/demo1-helloworld-deploy/
echo "启动jar包"
#nohup java -jar demo1-helloworld-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &
nohup java -jar demo1-helloworld-0.0.1-SNAPSHOT.jar &
echo "查看服务器启动日志"
#tailf /root/demo1-helloworld-deploy/logs/spring.log
tailf /root/demo1-helloworld-deploy/nohup.out
