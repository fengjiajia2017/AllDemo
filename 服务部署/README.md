# 服务部署
### 方案1：手动部署
> 环境准备
1. work服务器中安装git客户端
2. work服务器中安装java
3. work服务器中安装maven环境，设置仓库加速源
> 部署服务：
- 服务器运行[shell脚本](./server-deploy.sh)完成部署
1. 使用git拉取最新代码
2. 进行编译和打包
3. 搜索服务，如果存在服务，先停止当前运行的服务
4. 复制jar包到服务对应的目录
5. 启动服务
6. 日志显示


## 方案2：Jenkins自动化部署jar
> 环境准备
1. jenkins服务器中安装git客户端
2. jenkins服务器中安装java
3. jenkins服务器中安装maven环境，设置仓库加速源
4. jenkins服务器中安装jenkins
    1. 默认插件安装，手动maven integration、Publish Over SSH插件安装
    2. 全局工具配置中：配置jdk和maven（名称和Home目录)
    2. 系统配置中：配置work服务器SSH Server（名称、host、用户民、密码、远程目录）
5. work服务器中安装java
6. work服务器编写远程执行的[shell脚本](./jenkins-start.sh)
    1. 加载环境变量
    2. 搜索服务，如果存在服务，先停止当前运行的服务
    3. 拷贝jar包，从jenkins传输目录到部署目录
    4. 启动服务
> 添加Jenkins任务
1. 选择构建Maven项目
2. 配置git代码库地址
3. 配置maven build参数（pom，执行的命令）
4. 配置构建后操作，连接ssh server（work）
    1. 传输jar包配置：要传输的jar，去除传输jar的目录前缀，目标服务器目录（工作目录下）
    2. 配置执行命令：执行远程（work）的shell完成部署
> 部署服务：
1. 选择jenkins任务，点击立即构建


### 方案3：Jenkins自动化部署docker
> 环境准备
1. jenkins服务器准备，参照方案2
> 项目改造
1. 创建docker file
2. 配置mvn docker插件
> jenkins任务创建
1. 创建任务，配置git，配置shell命令执行
> 服务部署
1. 


### 方案4：Jenkins自动化部署docker
`使用jenkins进行自动化部署，创建服务docker镜像，上传到阿里云容器镜像中,` 
> 环境准备
1. 在服务器中安装git客户端
2. 在服务器中安装java和maven环境，设置仓库加速源
3. 在服务器中安装jenkins
4. 在服务器中安装Docker环境
> jenkins任务创建
1. 创建任务，配置git，配置shell命令执行
> 服务部署
1. 


### 方案5：Rancher容器管理