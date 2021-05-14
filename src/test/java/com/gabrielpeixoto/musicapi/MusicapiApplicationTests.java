package com.gabrielpeixoto.musicapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.gabrielpeixoto.musicapi.document.Musics;
import com.gabrielpeixoto.musicapi.repository.MusicsRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import java.util.List;
import static com.gabrielpeixoto.musicapi.constants.MusicsConstant.MUSICS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class MusicapiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	MusicsRepository musicsRepository;

	@Test
	public void getOneMusicByID()
	{
		webTestClient.get().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"), 4)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getOneMusicNotFound()
	{
		webTestClient.get().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"), 4)
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deleteMusic()
	{
		webTestClient.delete().uri(MUSICS_ENDPOINT_LOCAL.concat("/{id}"), 4)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}
}
