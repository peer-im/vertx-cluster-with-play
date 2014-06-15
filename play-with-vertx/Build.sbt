  name         := "playWithVertx"

  version      := "1.0-SNAPSHOT"

  libraryDependencies ++= Seq(
    // Add your project dependencies here,
    javaCore,
	"io.vertx" % "vertx-platform" % "2.1RC3", // playvertx
	"io.vertx" % "vertx-core" % "2.1RC3", // playvertx
	"io.vertx" % "vertx-hazelcast" % "2.1RC3", // playvertx
	"playhazelcast"  % "playhazelcast_2.10" % "2.6.7", // playvertx
	("playvertx"  % "playvertx_2.10" % "2.1RC1" notTransitive()) // playvertx
  )

  resolvers += Resolver.url("Fred's GitHub Play Repository", url("http://fmasion.github.com/releases/"))(Resolver.ivyStylePatterns)

  play.Project.playScalaSettings


