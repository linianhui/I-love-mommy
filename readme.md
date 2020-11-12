# Readme

给定一个不定长的字符串，如果其元音(aeiou)的数量占比超过30%，那么将每个连续的元音集合替换成"mommy". 例如：
* hard → hard
* his → hmommys
* hear → hmommyr

现在我们的任务有两个：

1. 重构代码，确保可读性和可维护性达到要求(Cognitive Complexity <= 16, issues == 0)。
2. 增加对大写元音（AEIOU）的支持(测试通过).

# 评价

**请首先修改`pom.xml`，将所有`YOUR-NAME`改成你的姓名。**

重构完成后可以用[sonarCloud.io](https://sonarcloud.io)来评价重构后的代码质量。

运行`analysis.sh`(Mac)或`analysis.bat`(Windows)将自动使用[sonarCloud.io](https://sonarcloud.io)进行静态代码分析。分析结果可以通过 [Refactoring-Java-Kata on sonarcloud.io](https://sonarcloud.io/dashboard?id=linianhui_I-love-mommy)  获取。

如果SonarCloud已经不支持Java8（2020年10月），请自行修改`pom.xml`，将`maven.compiler`改为11，并安装Java11本地开发环境。
