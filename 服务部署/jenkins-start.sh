#!/usr/bin/env bash
# 远程执行，需要加载环境变量，不然可能会找不到java命令
source /etc/profile

echo "检查现有进程是否启动，并进行停止"
# 找到pid，排除grep进程、bash进程，得到第一列值设置给pid
pid=$(ps x | grep "demo1-helloworld-0.0.1-SNAPSHOT.jar" | grep -v bash | grep -v grep | awk '{print $1}')
if [ -n "$pid" ]; then
echo "存在对应进程，正在停止"
echo $pid
kill -9 $pid
sleep 2s
fi

# jenkins已经把jar包传输到，/root/demo1-helloworld
echo "拷贝jar包"
cd /root/demo1-helloworld-deploy/
cp -rf /root/demo1-helloworld/demo1-helloworld-0.0.1-SNAPSHOT.jar /root/demo1-helloworld-deploy/
cd /root/demo1-helloworld-deploy/

echo "启动jar包"
nohup java -jar demo1-helloworld-0.0.1-SNAPSHOT.jar > nohup.log 2>&1 &
echo "启动jar的命令: nohup java -jar demo1-helloworld-0.0.1-SNAPSHOT.jar > nohup.log 2>&1 & "
echo "================== startup end ======================="

