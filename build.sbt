import skinny.servlet._
scalaVersion := "2.11.7"
libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-micro" % "1.0.3"            % "compile",
  "org.eclipse.jetty"    %  "jetty-webapp" % "9.2.15.v20160210" % "compile;container",
  "org.eclipse.jetty"    %  "jetty-plus"   % "9.2.15.v20160210" % "compile;container"
)
servletSettings
