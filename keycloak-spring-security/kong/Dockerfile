FROM kong:0.14-centos
#FROM kong:2.7.1-centos
LABEL description="Centos 7 + Kong 2.7.0 + kong-oidc plugin"
RUN yum install -y git unzip && yum clean all
RUN luarocks install kong-oidc