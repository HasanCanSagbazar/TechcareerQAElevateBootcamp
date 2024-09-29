from locust import HttpUser, between, task

class WebsiteUser(HttpUser):
    wait_time = between(5, 15)

    @task
    def userCreate(self):
        payload = {
            "id": 1256,
            "username": "johnDoe",
            "firstName": "John",
            "lastName": "Doe",
            "email": "johnDoe@example.com",
            "password": "123456",
            "phone": "05505550550",
            "userStatus": 0
        }
        self.client.post("/v2/user", json=payload)

    @task
    def login(self):
        self.client.get("/v2/user/login?username=johnDoe&password=123456")

    @task
    def getUserInfo(self):
        self.client.get("/v2/user/johnDoe")

    @task
    def updateUser(self):
        payload = {
            "id": 1256,
            "username": "johnDoe2",
            "firstName": "John",
            "lastName": "Doe",
            "email": "johnDoe@example.com",
            "password": "123456",
            "phone": "05505550550",
            "userStatus": 0
        }
        self.client.put("/v2/user/johnDoe2", json=payload)

    @task
    def logout(self):
        self.client.get("/v2/user/logout")

    @task
    def deleteUser(self):
        self.client.delete("/v2/user/johnDoe2")

