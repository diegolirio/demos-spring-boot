#FROM kong:0.14-centos
##FROM kong:2.7.1-centos
#LABEL description="Centos 7 + Kong 2.7.0 + kong-oidc plugin"
#RUN yum install -y git unzip && yum clean all
#RUN luarocks install kong-oidc




#FROM kong:latest
#
## Install LuaRocks
#RUN apk --no-cache add lua5.1-dev gcc musl-dev
#RUN wget https://luarocks.org/releases/luarocks-3.7.0.tar.gz && \
#    tar zxpf luarocks-3.7.0.tar.gz && \
#    cd luarocks-3.7.0 && \
#    ./configure --prefix=/usr/local/luarocks --lua-version=5.1 --with-lua=/usr/local/kong/luajit && \
#    make build install
#
## Install the OIDC plugin
#RUN /usr/local/luarocks/bin/luarocks install kong-oidc --local




#FROM luarocks/luarocks:alpine
FROM akorn/luarocks:luajit2.1-alpine

# Install the OIDC plugin
RUN luarocks install kong-oidc --local