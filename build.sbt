import skinny.servlet._
scalaVersion := "2.11.8"
libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-micro" % "1.1.0"            % "compile",
  "org.eclipse.jetty"    %  "jetty-webapp" % "9.2.18.v20160721" % "compile;container",
  "org.eclipse.jetty"    %  "jetty-plus"   % "9.2.18.v20160721" % "compile;container"
)
servletSettings
