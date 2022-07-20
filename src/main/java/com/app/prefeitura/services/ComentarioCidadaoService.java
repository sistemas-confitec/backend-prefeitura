package com.app.prefeitura.services;

import com.app.prefeitura.dto.ComentarioCidadaoDTO;
import com.app.prefeitura.dto.FotoDTO;
import com.app.prefeitura.entities.Arquivo;
import com.app.prefeitura.entities.ComentarioCidadao;
import com.app.prefeitura.repositories.ArquivoRepository;
import com.app.prefeitura.repositories.ComentarioCidadaoRepository;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Robson
 */
@Service
public class ComentarioCidadaoService {

    @Value("${diretorio.perfil.raiz}")
    private String raiz;

    @Value("${diretorio.perfil.pasta-fotos}")
    private String diretorioFotos;

    private Path arquivoPath = null;

    @Autowired
    private ComentarioCidadaoRepository repository;
    
    @Autowired
    private ArquivoRepository arquivoRepository;

    @Transactional
    public List<ComentarioCidadao> findAll() {
        return (List<ComentarioCidadao>) repository.findAll();
    }

    public ComentarioCidadao insert(ComentarioCidadaoDTO comentario) {
        ComentarioCidadao entity = new ComentarioCidadao(comentario.getComentario(), arquivoPath.toString());
        repository.save(entity);

        return entity;
    }

    public void upload(MultipartFile foto) throws IOException {
        Path diretorioPath = (Path) Paths.get(raiz, diretorioFotos);
        arquivoPath = diretorioPath.toAbsolutePath().resolve(foto.getOriginalFilename());
        Files.createDirectories(diretorioPath);
        foto.transferTo(arquivoPath.toFile());
    }
    
    public void uploadFoto(FotoDTO foto, String idComentario) throws IOException{
        
        String caminhoRelativo = Path.of(raiz).toAbsolutePath().toString();
        //transforma a foto em base64 para array de bytes
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(foto.getBase64());
        String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(imageBytes));
        String extensao = mimeType.substring(mimeType.lastIndexOf("/")).replace("/", ".");
        String nomeArquivo = idComentario + extensao;
        //Criar a entidade Arquivo
        Arquivo arquivo = new Arquivo();
        arquivo.setDataUpload(LocalDateTime.now());
        //URL e UTILIZADA PARA SERVIR OS ARQUIVOS NECESSARIO SUBSTITUIR A BARRA PARA INVERTIDA
        arquivo.setUrl(arquivo.getLocalizacao().replace("\\\\", "/"));
        //obtém a extensão a partir do array de bytes
        arquivo.setWidth(foto.getWidth());
        arquivo.setHeight(foto.getHeight());
        arquivo.setNomeOriginal(nomeArquivo);
        arquivo.setNomeAtual(foto.getName());
        //Salva a entitdade Arquivo no banco de dados
        arquivoRepository.save(arquivo);
        
        String caminho = caminhoRelativo + File.separator + idComentario;
        
        File pasta = new File(caminho);
        if(!pasta.exists()){
            System.out.println("Tentando criar pasta:");
            System.out.println(caminho);
            pasta.mkdirs();
        }
        
        //transforma a extensão de image/jpg para .jpg
//        java.nio.file.Path parthFile = Paths.get(uri)
        
        
    }
}
