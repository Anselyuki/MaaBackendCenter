# MaaBackendCenter

使用 Java 重写的 MAA 作业服务器后端

## 开发技术栈

- Java 17
- SpringBoot 3
    - spring-security
    - springdoc-openapi
- MongoDB
- Redis

## 本地开发指南

1. 下载安装 jdk 17 或者以上版本的 jdk，可以考虑从 [zuluJDK](https://www.azul.com/downloads/?version=java-17-lts&package=jdk) 或者 [libreicaJDK](https://bell-sw.com/pages/downloads/#/java-17-lts) 下载安装
2. 你需要一个有redis和mongoDB的环境，如果你是windows用户，可以从 https://github.com/tporadowski/redis 中下载版本较旧的 redis 使用
3. 使用你喜欢的 IDE 导入此项目，修改 /src/main/resources/application-template.yml 中的数据库配置以符合你自己配置的环境
4. 运行 MainApplication 类里的 main 方法
5. 首次运行建议修改 ArkLevelSyncTask 类的scheduled注解的参数，这样可以将明日方舟中的关卡数据同步到你本地的 mongodb 中，为了防止反复调用造成调试的麻烦，建议首次运行同步成功后再将代码修改回去

## 项目结构

- config 存放spring配置
- controller 交互层
    - request 入参类型
    - response 响应类型
- repository 数据仓库层，用于和数据库交互
    - entity 与数据库字段对应的类型
- service 业务处理层，复杂或者公用逻辑放在这里（注：您无需为每个类型都提供对应接口，只有当接口在可见未来有多个实现的时候才考虑建立接口）
    - model 应用内传输用类型放这里
- utils 工具类

## 编译与部署

1. 安装 jdk17，可以考虑从 [zuluJDK](https://www.azul.com/downloads/?version=java-17-lts&package=jdk) 或者 [libreicaJDK](https://bell-sw.com/pages/downloads/#/java-17-lts) 下载
2. clone 此项目 `git clone https://github.com/MaaAssistantArknights/MaaBackendCenter.git`
3. 进入此项目目录 `cd MaaBackendCenter`
4. 编译项目 `./gradlew bootJar -x processAot`，windows环境下请使用 `gradlew.bat bootJar -x processAot`
5. 获得编译后的 jar 文件 `cp ./build/libs/MaaBackendCenter-1.0-SNAPSHOT.jar .`
6. 复制一份配置文件 `cp ./build/resources/main/application-template.yml ./application-prod.yml`
7. 修改配置文件 `application-prod.yml`
8. 运行项目 `java -jar MaaBackendCenter-1.0-SNAPSHOT.jar --spring.profiles.active=prod`

## native 编译（暂时废弃，如果希望协助维护，请查看native分支）

1. 安装 [GraalVM](https://github.com/graalvm/graalvm-ce-builds/releases)
   Java17，并配置好环境变量，部分功能需要正确配置 `JAVA_HOME` 变量为 GraalVM 安装目录才能正常使用
2. 如果您处于 Windows 环境下，需要安装 `Visual Studio` 并且安装 C++ 组件，Linux 环境下则需要安装 `gcc` 工具链，Mac
   下需要安装 `xcode`
   工具链，详情查看 [native-image#prerequisites](https://www.graalvm.org/22.3/reference-manual/native-image/#prerequisites)
3. 通过 `gu install native-image` 安装 `native-image` AOT 编译器
4. 在该项目目录下，执行 `./gradlew nativeRun` 或者 `.\gradlew.bat nativeRun` 编译并运行该项目
5. 如果您希望产生 docker image，请执行 `./gradlew bootBuildImage`

## Join us!

QQ Group: 724540644
