### deploy applocation using yaml files
PS D:\GitHub\sb-k8s-demo> docker build -t sb-k8s-demo .
docker image tag sb-k8s-demo:latest  indrajith007/sb-k8s-demo:latest
docker login https://index.docker.io/v1/ -u indrajith007 -p Axx@123$
ocker push  indrajith007/sb-k8s-demo:lates
# execute deployment yaml file

		kubectl apply -f sb-k8s-demo-deployment.yaml

		kubectl get deployments
		kubectl get pods
		kubectl get nodes
		kubectl logs podname

		PS D:\GitHub\sb-k8s-demo> kubectl apply -f sb-k8s-demo-deployment.yaml
		deployment.apps/sb-k8s-demo created
		PS D:\GitHub\sb-k8s-demo> kubectl get deployments
		NAME          READY   UP-TO-DATE   AVAILABLE   AGE
		sb-k8s-demo   3/3     3            3           14s
		PS D:\GitHub\sb-k8s-demo> kubectl get pods
		NAME                           READY   STATUS    RESTARTS   AGE
		sb-k8s-demo-6fb67dcd67-lzzlb   1/1     Running   0          61s
		sb-k8s-demo-6fb67dcd67-pv95q   1/1     Running   0          61s
		sb-k8s-demo-6fb67dcd67-zg6ms   1/1     Running   0          61s
		PS D:\GitHub\sb-k8s-demo> kubectl get nodes
		NAME       STATUS   ROLES           AGE   VERSION
		minikube   Ready    control-plane   8h    v1.30.0
		PS D:\GitHub\sb-k8s-demo> kubectl logs sb-k8s-demo-6fb67dcd67-zg6ms

# execute service yaml file

		kubectl apply -f sb-k8s-demo-service.yaml

		PS D:\GitHub\sb-k8s-demo> kubectl apply -f sb-k8s-demo-service.yaml
		service/sb-k8s-demo-svc created
		PS D:\GitHub\sb-k8s-demo> kubectl get services
		NAME              TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
		kubernetes        ClusterIP   10.96.0.1      <none>        443/TCP          144m
		sb-k8s-demo-svc   NodePort    10.97.27.118   <none>        8080:30762/TCP   10s
		PS D:\GitHub\sb-k8s-demo>


# get node ip

	kubectl get nodes -o wide

	PS D:\GitHub\sb-k8s-demo> kubectl get nodes -o wide
	NAME       STATUS   ROLES           AGE   VERSION   INTERNAL-IP    EXTERNAL-IP   OS-IMAGE             KERNEL-VERSION                     CONTAINER-RUNTIME
	minikube   Ready    control-plane   8h    v1.30.0   192.168.49.2   <none>        Ubuntu 22.04.4 LTS   6.6.87.2-microsoft-standard-WSL2   docker://26.1.1
	PS D:\GitHub\sb-k8s-demo>


# get minikube ip

	PS D:\GitHub\sb-k8s-demo> minikube ip
	192.168.49.2
	PS D:\GitHub\sb-k8s-demo>

# Test&Validate service

http://127.0.0.1:63231/welcome

PS D:\GitHub\sb-k8s-demo> kubectl get pods
NAME                           READY   STATUS    RESTARTS   AGE
sb-k8s-demo-6fb67dcd67-lzzlb   1/1     Running   0          77m
sb-k8s-demo-6fb67dcd67-pv95q   1/1     Running   0          77m
sb-k8s-demo-6fb67dcd67-zg6ms   1/1     Running   0          77m
PS D:\GitHub\sb-k8s-demo> kubectl get services
NAME              TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
kubernetes        ClusterIP   10.96.0.1      <none>        443/TCP          3h40m
sb-k8s-demo-svc   NodePort    10.97.27.118   <none>        8080:30762/TCP   76m
PS D:\GitHub\sb-k8s-demo> minikube service sb-k8s-demo-svc
|-----------|-----------------|-------------|---------------------------|
| NAMESPACE |      NAME       | TARGET PORT |            URL            |
|-----------|-----------------|-------------|---------------------------|
| default   | sb-k8s-demo-svc |        8080 | http://192.168.49.2:30762 |
|-----------|-----------------|-------------|---------------------------|
* Starting tunnel for service sb-k8s-demo-svc.
|-----------|-----------------|-------------|------------------------|
| NAMESPACE |      NAME       | TARGET PORT |          URL           |
|-----------|-----------------|-------------|------------------------|
| default   | sb-k8s-demo-svc |             | http://127.0.0.1:63231 |
|-----------|-----------------|-------------|------------------------|
* Opening service default/sb-k8s-demo-svc in default browser...
! Because you are using a Docker driver on windows, the terminal needs to be open to run it.

	http://127.0.0.1:63231/k8s-demo/welcome


#open kubernetes dashboard

  minikube dashboard


PS D:\GitHub\sb-k8s-demo> minikube dashboard
* Verifying dashboard health ...
* Launching proxy ...
* Verifying proxy health ...
* Opening http://127.0.0.1:56233/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/ in your default browser...