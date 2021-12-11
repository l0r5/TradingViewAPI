#!/usr/bin/env groovy

def pairs = [
        ["pair": "ADA/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "BTC/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "DASH/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "DOT/USDT", "timeFrame": "18m", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "EOS/USDT", "timeFrame": "4h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "ETH/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "LRC/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "LTC/USDT", "timeFrame": "30m", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "QTUM/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "XRP/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "XTZ/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
        ["pair": "ZEC/USDT", "timeFrame": "1h", "emasarSettings": "EMASAR 50/200/48 Bankroll:10k"],
]

def outputFile = new File('alarms_pair.txt')
def pairAlarmsFile = new File('pair_alarms.template')
def allAlarmsFile = new File('all_alarms.template')
def engine = new groovy.text.GStringTemplateEngine()

def allAlarmsString = ""
pairs.forEach { pair ->
    def pairTemplate = engine.createTemplate(pairAlarmsFile).make(pair)
    allAlarmsString = allAlarmsString.concat(pairTemplate.toString())
}

def allAlarmsTemplate = engine.createTemplate(allAlarmsFile).make(["pairAlarms": allAlarmsString])
outputFile.text = allAlarmsTemplate.toString()
println("Script ended.")