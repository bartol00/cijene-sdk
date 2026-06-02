import org.junit.jupiter.api.Test;
import com.cijene.sdk.models.zip.ZipArchives;
import com.cijene.sdk.service.ZipArchivesService;
import com.cijene.sdk.service.impl.ZipArchivesServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static shared.TestHelpers.*;

public class ZipArchivesServiceTest {

    @Test
    void getZipArchivesSuccess() {
        // given
        ZipArchivesService service = new ZipArchivesServiceImpl(apiClient);

        // when
        ZipArchives zipArchives = service.getZipArchives();

        // then
        assertNotNull(zipArchives);
        assertNotEquals(0, zipArchives.getArchives().size());
    }

}
