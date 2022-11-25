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
        
        maven('install', 'maven-samples/single-module/pom.xml')
    }

    publishers {

        archiveArtifacts '**/*.war'
    }

}
