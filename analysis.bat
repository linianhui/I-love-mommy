SET SONAR_TOKEN=73243c2f3e2108ef877220b48d15be821eb7c50f
mvn clean verify site spotbugs:spotbugs com.github.meixuesong:merge-cpd-pmd-report-maven-plugin:1.0:merge sonar:sonar
