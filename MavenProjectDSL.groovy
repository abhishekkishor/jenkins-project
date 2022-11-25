job('DSL-Job') {
    description("Writing a DSL Job")
    logRotator(2, 2)
    scm {
        git("https://github.com/abhishekkishor/jenkinsproject.git", 'master')
    }

    triggers {
        scm('* * * * *')
    }

    wrappers {
        timestamps()
    }

    steps {
        
        maven('install', 'java-tomcat-sample/pom.xml')
    }

    publishers {

        archiveArtifacts '**/*.war'
    }

}
