# HiScore API

## Welcome

Hi! Welcome to the HiScore API, a simple REST API for registering the high scores of your games.  
  
This project aims to provide an easy-to-use API for our indie and jam games, allowing us to register and display scoreboards.

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

- **name**:  This is your game's name, used for illustrative purposes and for searching;
- **key**: A key, passphrase, hash, or any password you choose for your game. It will be required when recording new scores, along with the game's ID, which is returned when your game is registered;
- **defaultSortingField**: The name of the field that represents the player's main score. When querying top scores, if no sorting field is specified, this field will be used to sort the scores;
- **ascending**: Determines whether the scores will be ordered in ascending order. By default, it is set to false, meaning scores are usually sorted from highest to lowest. However, in some cases, such as racing games, you may want to sort scores from lowest to highest (e.g., fastest lap time).

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
        "name": "Game Master",
        "defaultSortingField": "score",
        "ascending": false
    },
    {
        "id": "6df3240b-9e43-49ca-887a-9e6e10de003d",
        "name": "My game",
        "defaultSortingField": "frags",
        "ascending": false
    },
    {
        "id": "3e2c602b-0f12-482c-92bf-e8fed208e9ac",
        "name": "Simple Race Game",
        "defaultSortingField": "time",
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

You may notice that the `key` field is not returned, either during creation or listing. Therefore, make sure to store its value securely!

### Search for your game
`GET {host}/games?name=game`

- **name**: A case-insensitive part of the game name. It will list all games that contain this value in their name.

Return:
```json
[
    {
        "id": "429840d7-8576-4d7d-8804-729527aea9f8",
        "name": "Game Master",
        "defaultSortingField": "score",
        "ascending": false
    },
    {
        "id": "6df3240b-9e43-49ca-887a-9e6e10de003d",
        "name": "My game",
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

- **gameId**: The UUID of your game;
- **gameKey**: The secret key of your game, ensuring that only you can register scores for your game;
- **scoreInfo**: A list of key-value pairs to store score information.
Typically, two pairs are sufficient: one for player identification (e.g., player in the example) and another for score details. In the example, we use three fields for score information, with points as the default sorting field.
You can use as many fields as you need, as long as they are stored as strings. The sorting fields must be convertible to decimal numbers. For example, to store time, convert it to the smallest unit. Do not save something like `7:20.872`.


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

- **startDate** _(optional)_:  The start date for the search, in ISO 8601 format: `yyyy-MM-ddTHH:mm:ss.sss`. If omitted, the default is 30 days before the current moment;
- **endDate** _(optional)_: The end date for the search, in ISO 8601 format: `yyyy-MM-ddTHH:mm:ss.sss`. If omitted, the default is the current moment;
- **sortingField** _(optional)_: The field used to sort the search results. If omitted, the default sorting field registered in the game will be used. If the field does not exist, an error will be raised;
- **isAscending** _(optional)_: Specifies whether the results should be ordered in ascending or descending order. If omitted, descending order is assumed.

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