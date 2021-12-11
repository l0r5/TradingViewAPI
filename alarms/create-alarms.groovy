#!/usr/bin/env groovy

def binding = ["firstname":"Sam", "lastname":"Pullara"]

def f = new File('alarms_input.template')
def engine = new groovy.text.GStringTemplateEngine()
def template = engine.createTemplate(f).make(binding)

println template.toString()