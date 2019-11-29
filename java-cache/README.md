
# JMICROS CACHE


## Build Prerequisites

1. corretto 1.8
2. gradle 3.4.1

## Build

gradle clean assemble fatjar && docker build -t jmicros .

## Deployment Instructions

docker-compose up -d memcache jmicros

## Test

curl -i http://localhost:8050/jmicros-api/rest/jugbol/map/5 -w "\n"




