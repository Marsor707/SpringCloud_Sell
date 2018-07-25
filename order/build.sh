mvn clean package -Dmaven.test.skip=true -U

docker build -t registry.cn-hangzhou.aliyuncs.com/marsor/order . --rm

docker push registry.cn-hangzhou.aliyuncs.com/marsor/order