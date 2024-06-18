# Prometheus and Grafana

## Run Prometheus and Grafana in Docker
Create docker network
```shell
docker network create monitoring
```

Run Prometheus
```shell
docker run --name prometheus --network monitoring -p 9090:9090 \
-v github/interview-preparation/spring/micrometer/src/main/resources/prometheus.yml prom/prometheus
```

Run Grafana
```shell
docker run --name grafana --network monitoring -p 3000:3000 grafana/grafana
```

## Configure Prometheus Data Source in Grafana
### Access Grafana
- Open your browser and go to http://localhost:3000.
- Log in (default credentials are usually admin/admin).

### Add Prometheus Data Source
- Go to the Configuration (gear icon) > Data Sources.
- Click Add data source.
- Select Prometheus.
- In the HTTP section, set the URL to http://prometheus:9090. 
  - Note: `prometheus` is the name of the Prometheus container, which Docker will resolve to the correct IP address within the monitoring network.
- Click Save & Test to verify the connection.

## Verify Network Connectivity
Access Grafana Container
```shell
docker exec -it grafana /bin/bash
```

Ping Prometheus Container
```shell
ping prometheus
```

If the ping is successful, it means the containers can communicate over the network.
