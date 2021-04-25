# RepositoryFinder
***
This project is part of Allegro Summer e-Xperience recruitment process.

### The aim of the task:
Create software allowing for:
  - list all repositories (names and number of stars)
  - return total number of stars from all repositories
  
from any existing GitHub account.
 
 Data should be returned by HTTP protocol.
 
### Instalation
To run whole app you need to clone this project to your Intellij IDEA from GitHub link. Then wait for gradle to build and just run app. App is available on `http://localhost:8889/`. You can get there by your browser (JSONView add-on recommended) or external application e.g. Postman.

### Examples

###### Get repositories for user 'drpawel'

Request: `GET /api/user/drpawel`

Response:
```JSON
{
    "username": "drpawel",
    "total_stars": 1,
    "repositories": [
        {
            "repo_name": "Code-Sharing-Platform",
            "stars_count": 0
        },
        ...
        {
            "repo_name": "Watermark",
            "stars_count": 0
        }
    ]
}
```
###### Get repositories for user that don't exist

Request: `GET /api/user/userthatdontevenexist`

Response:
```JSON
{
    "message": "user not found"
}
```
