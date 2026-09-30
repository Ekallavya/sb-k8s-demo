###instructions to deploy application using kubectl commands

## start docker engine & docker login & create docker image
	docker build -t sb-k8s-demo-demo:1.0 .

	docker image tag sb-k8s-demo-demo:1.0 indrajith007/sb-k8s-demo-demo:1.0

	docker image push indrajith007/sb-k8s-demo-demo:1.0

## deploy docker image to kubernetes

	kubectl create deployment sb-k8s-demo-demo-test --image=sb-k8s-demo-demo:1.0  --port=8080
## describe deployment

	kubectl describe deployment sb-k8s-demo-demo-test

    kubectl get deployments

	kubectl get nodes

	kubectl get pods

	kubectl logs sb-k8s-demo-demo-test-69b9d7d7b9-t4kk5


## expose deployment

	kubectl expose deployment sb-k8s-demo-demo-test --type=NodePort

## verify port or service name details

   kubectl get services

PS D:\U360_SpringBootMicroservices\999_javatechie\sb-k8s-demo-demo> kubectl get services
NAME                       TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
kubernetes                 ClusterIP   10.96.0.1      <none>        443/TCP          9h
mysql                      ClusterIP   None           <none>        3306/TCP         9h
sb-k8s-demo-demo-test   NodePort    10.98.59.111   <none>        8080:30110/TCP   10m

## get service url

	minikube service sb-k8s-demo-demo-test

PS D:\U360_SpringBootMicroservices\111_universe\sb-k8s-demo> minikube service sb-k8s-demo-test
|-----------|------------------|-------------|---------------------------|
| NAMESPACE |       NAME       | TARGET PORT |            URL            |
|-----------|------------------|-------------|---------------------------|
| default   | sb-k8s-demo-test |        8080 | http://192.168.49.2:31442 |
|-----------|------------------|-------------|---------------------------|
* Starting tunnel for service sb-k8s-demo-test.
|-----------|------------------|-------------|------------------------|
| NAMESPACE |       NAME       | TARGET PORT |          URL           |
|-----------|------------------|-------------|------------------------|
| default   | sb-k8s-demo-test |             | http://127.0.0.1:57818 |
|-----------|------------------|-------------|------------------------|

## test service endpoint
	http://192.168.49.2:30110/k8s-demo/message

	http://127.0.0.1:57818/k8s-demo/message

## to view kubernetes Dashboard

   minikube dashboard