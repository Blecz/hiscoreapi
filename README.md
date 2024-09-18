# HiScore API

## Welcome

Hi! Welcome to the  HiScore API! A simple REST API to register the high scores of your games.  
This project aims to provide an simple API to be used by our indie and jam games, allowing us to register and dispalay scoreboards for them.

## Games API

### Register a new game
`POST {host}/games`

Body:
```json
{
    "name": "Your Game Name",
    "key": "yourPersonalAccessKeyToYourGame",
    "defaultSortingField": "fieldNameForDefaultClassification",
    "ascending": true
}
```

- **name**: It's your game name, for illustrative purposes only. And for searching too;
- **key**: It's a key, passphrase, hash, whatever you want to use as password of your game. It will be needed when recording new scores to your game, along with her ID, returned when your game is registered;
- **defaultSortingField**: The name of the field that usually represents the main score of the player. When querying the top scores, if the sorting field is not informed, then the field with this name will be used to sort the scores;
- **ascending**: Means the ordering will be ascending. By default, it's false. Commonly, the scores begins with the highest. But in some cases, like in a racing game, you may want to order the scores beginning with the lowest, like the fastest lap, as example.

Return:
```json
{
    "id": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
    "name": "Simple Example",
    "defaultSortingField": "points",
    "ascending": false
}
```

### List existing games
`GET {host}/games`

Return:
```json
[
    {
        "id": "429840d7-8576-4d7d-8804-729527aea9f8",
        "name": "Jogo exemplo",
        "defaultSortingField": "score",
        "ascending": false
    },
    {
        "id": "6df3240b-9e43-49ca-887a-9e6e10de003d",
        "name": "Meu jogo",
        "defaultSortingField": "frags",
        "ascending": false
    },
    {
        "id": "3e2c602b-0f12-482c-92bf-e8fed208e9ac",
        "name": "Corridinha",
        "defaultSortingField": "tempo",
        "ascending": true
    },
    {
        "id": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
        "name": "Simple Example",
        "defaultSortingField": "points",
        "ascending": false
    }
]
```

You can observe that the field `key` isn't returned. Not in creation either in listing. So, store his value securely!

### Search for your game
`GET {host}/games?name=jogo`

- **name**: Case-insensitive game name part. It willl list all the games that contains this value in the name.

Return:
```json
[
    {
        "id": "429840d7-8576-4d7d-8804-729527aea9f8",
        "name": "Jogo exemplo",
        "defaultSortingField": "score",
        "ascending": false
    },
    {
        "id": "6df3240b-9e43-49ca-887a-9e6e10de003d",
        "name": "Meu jogo",
        "defaultSortingField": "frags",
        "ascending": false
    }
]
```

## Scores API

### Register scores
`POST {host}/scores`

Body:
```json
{
    "gameId": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
    "gameKey": "superSecretPlus",
    "scoreInfos": [
        {
            "player": "LoPan",
			"points": "180",
            "coins": "80",
            "time": "100"
        }
    ]
}
```

- **gameId**: UUID of your game;
- **gameKey**: Secret key of your game. Ensures that only you can register scores for your game;
- **scoreInfo**: List of key-value pairs to store the score information.  
Usually, 2 pairs may be sufficient: one for player identification (`player` in the example) and another for score information. In the example, we have 3 fields of score information, being `points` the default sorting field.  
You can use how many fields you want, since they be stored as strings, and the sorting fields can be converted to decimal numbers. So, to store time, by example, convert to the minor unit. **Don't** save something like `7:20.872`.


Return:
```json
[
    {
        "gameId": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
        "scoreInfo": {
            "player": "LoPan",
            "points": "180",
            "coins": "80",
            "time": "100"
        },
        "timestamp": "2024-09-17T22:07:52.9143247"
    }
]
```

### Query scores
```
GET {host}/scores/:gameId
?startDate=2024-09-18T00:00:00.000
&endDate=2024-09-18T23:59:59.999
&sortingField=coins
&isAscending=false
```

- **startDate** _(optional)_: The start date of the search. ISO 8601 format: `yyyy-MM-ddTHH:mm:ss.sss`. If ommited, assumes the actual moment minus 30 days.
- **endDate** _(optional)_: The end moment of the search. ISO 8601 format: `yyyy-MM-ddTHH:mm:ss.sss`. If ommited, assumes the actual moment.
- **sortingField** _(optional)_: Sorting field to classify the results of the search. If ommited, assumes the default sorting field registered in the game. If the field doesn't exists, raises an error.
- **isAscending** _(optional)_: Informs if the ordering of results will be ascending or descending. If ommited, it will be considered descending.

Return:
```json
[
    {
        "gameId": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
        "scoreInfo": {
            "player": "Diana",
            "points": "120",
            "coins": "80",
            "time": "40"
        },
        "timestamp": "2024-09-18T11:17:10.436"
    },
    {
        "gameId": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
        "scoreInfo": {
            "player": "Samantha",
            "points": "135",
            "coins": "73",
            "time": "62"
        },
        "timestamp": "2024-09-18T11:17:10.436"
    },
    {
        "gameId": "4c6a0b8a-7761-452c-8097-e8812b18ab2d",
        "scoreInfo": {
            "player": "Stella",
            "points": "136",
            "coins": "71",
            "time": "75"
        },
        "timestamp": "2024-09-18T11:17:10.436"
    }
]
```