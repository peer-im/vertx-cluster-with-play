#Play Embedded Vertx cluster with VertX Instance Demo

## Prerequisite
=========
* Vertx 2.1RC3
* Play 2.2.X
* PlayVertx https://github.com/fmasion/playVertX
* sbt 0.13.X


## Setup
=========

$ vi $VERTX_HOME/conf/logging.properties
    
	org.vertx.level = FINER
    com.hazelcast.level = INFO	

$ vi $VERTX_HOME/conf/cluster.xml

    <multicast enabled="true">
        <multicast-group>224.2.2.3</multicast-group>
        <multicast-port>54327</multicast-port>
    </multicast>
    <tcp-ip enabled="false">
        <interface>192.168.1.28</interface>
    </tcp-ip>

$ git clone https://github.com/fmasion/playVertX
$ cd playVertx/project-code
$ sbt clean stage
$ cp target/scala-2.10/playvertx_2.10-2.1RC1.jar $VERTX_HOME/lib/

## Run
=========

### open a terminal
    $ cd playWithVertx
    $ play start

### open another terminal
    $ cd vertx-sockjs
    $ gradle clean build install
    $ cd ..
    $ vertx runmod vertx.io~sockjsserver~0.1 -conf conf/server.json -cluster


    