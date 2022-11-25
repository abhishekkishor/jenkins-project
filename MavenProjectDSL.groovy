job('DSL-Job') {
    description("Writing a DSL Job")
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
