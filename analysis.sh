#!/bin/bash

export SONAR_TOKEN=62f031b88aa1d3ee54aec9bcbf6acd896ecaa991
mvn clean verify site spotbugs:spotbugs com.github.meixuesong:merge-cpd-pmd-report-maven-plugin:1.0:merge sonar:sonar
