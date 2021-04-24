# RepositoryFinder
***
This project is part of Allegro Summer e-Xperience recruitment process.

The aim of the task:
Create software allowing for:
  -list all repositories (names and number of stars)
  -return total number of stars from all repositories
 from any GitHub account.
 
 Data should be returned by HTTP protocol.

### Examples

###### Example

Request: `GET /user/drpawel`

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
