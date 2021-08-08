APPNAME=mybatis-plus
PORT=8082
docker build -t $APPNAME .
docker run -itd --name $APPNAME -p $PORT:$PORT $APPNAME
