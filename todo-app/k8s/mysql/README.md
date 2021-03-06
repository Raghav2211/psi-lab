#  MySql Helm Chart


## Introduction

This chart bootstraps a single node MySQL deployment on a [Kubernetes](http://kubernetes.io) cluster using the [Helm](https://helm.sh) package manager.

## Prerequisites

- Kubernetes 1.19.2
- PV provisioner support in the underlying infrastructure

## Installing the Chart

To install the chart with the release name `mysql` with respective environment secret file:

```bash
# Verify the configuration 
$ helm install --dry-run --debug mysql mysql -f mysql/env/<env>/secrets.yaml

# Install chart
$ helm install mysql mysql -f mysql/env/<env>/secrets.yaml
```

To install the chart with the release name `mysql` with respective environment secret and configuration file:

```bash
# Verify the configuration 
$ helm install --dry-run --debug mysql mysql -f mysql/env/<env>/secrets.yaml -f mysql/env/<env>/values.yaml

# Install chart
$ helm install mysql mysql -f mysql/env/<env>/secrets.yaml -f mysql/env/<env>/values.yaml
```

## Uninstalling the Chart

To uninstall/delete the `mysql` deployment:

```bash
$ helm uninstall mysql
```

## Configuration

The following table lists the configurable parameters of the MySQL chart and their default values.

| Parameter                                    | Description                                                                                  | Default                                              |
| -------------------------------------------- | -------------------------------------------------------------------------------------------- | ---------------------------------------------------- |
| `replica`                                 | Number of instance to run at any time                                                      | 1 |
| `image`                                        | `mysql` image configuration.                                                               | ` ` |
| `image.repository`                             | `mysql` image repository.                                                                  | `mysql`|
| `image.pullPolicy`                             | `mysql` image pull policy.                                                                 | `IfNotPresent`|
| `image.tag`                                    | `mysql` image tag.                                                                         | `8.0.22`|
| `service`                                      | `mysql` service configuration                                                              | ` ` |
| `service.type`                                 | Kubernetes service type                                                                    | `ClusterIP`|
| `service.port`                                 | Service Port to be exposed outside                                                         | 3306 |
| `resources`                                    | `mysql` CPU/Memory resource requests/limits                                                | `{}` |
| `persistence`                                  | persistence is to recover data after pod kill                                              | `{}` |
| `persistence.enabled`                          | persistence is enabled or not                                                              | `false `  |
| `persistence.storageClass`                     | Type of persistent volume claim                                                            | ` `  |
| `persistence.accessMode`                       | ReadWriteOnce or ReadOnly                                                                  | ` `  |
| `persistence.size`                             | Size of persistent volume claim                                                            | ` `  |
| `persistence.hostPath`                         | HostPath of the volume to mount                                                            | ` `  |
| `config`                                       | Configuration for mysql                                                                    | `{ database: psi }`  |
| `config.database`                              |  Database name                                                                             | `psi`|
| `username`                                     |  Database user name                                                                        | ` `  |
| `password`                                     |  Database password                                                                         | ` `  |
| `rootPassword`                                  |  Database root user password                                                              | ` `  |
| `nodeAffinity`                                 | Assign Pods to Nodes using Node Affinity                                                   | `[]` |



## Persistence

A PersistentVolume (PV) is a piece of storage in the cluster that has been provisioned by an administrator or dynamically provisioned using Storage Classes. It is a resource in the cluster just like a node is a cluster resource. PVs are volume plugins like Volumes, but have a lifecycle independent of any individual Pod that uses the PV, so even if the application pod gets down still the backend data will be retained and when applicatin pod will be up then , persisted data can be accessed.

PersistentVolume will be created if `persistence.enabled` is set to `true` and if true then data will be  mounted into specified directory. In order to disable this functionality `persistence.enabled` should be set to `false`.
