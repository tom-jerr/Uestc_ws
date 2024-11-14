# 注意 若命令失效，请在 root 用户权限下执行，或将当前用户加入 docker

1.  docker compose -f compose.yml build baseserver // 启动构建镜像的服务
2.  docker compose -f compose.yml up server1 server2 server3 // 启动三个 cache server 服务
3.  bash sdcs-test.sh // 执行测试脚本
