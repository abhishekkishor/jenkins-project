job('DSL-Job') {
    description("Writing a DSL Job")
    logRotator(2, 2)
    scm {
        git("git@github.com:abhishekkishor/jenkinsproject.git", master)
    }

    triggers {
        scm('* * * * *')
    }

    wrappers {
        timestamps()
    }

    steps {
        
        maven('install', 'jave-tomcat-sample/pom.xml')
    }

    publishers {

        archiveArtifacts '**/*.war'
    }

}
