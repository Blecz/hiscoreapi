package com.lopan.hiscoreApi.domain.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreWrapperDTO {

    private UUID gameId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String gameKey;
    private List<Map<String, String>> scoreInfos;

}
