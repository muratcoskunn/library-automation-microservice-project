package com.sahabt.borrowmicroservice.service.business;

import com.sahabt.borrowmicroservice.dto.BorrowRequest;
import com.sahabt.borrowmicroservice.entity.BorrowDocument;
import com.sahabt.borrowmicroservice.repository.BorrowMongoRepository;
import com.sahabt.borrowmicroservice.service.BorrowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BorrowServiceImplementation implements BorrowService {
    BorrowMongoRepository borrowMongoRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ModelMapper modelMapper;

    public BorrowServiceImplementation(BorrowMongoRepository borrowMongoRepository) {
        this.borrowMongoRepository = borrowMongoRepository;
    }

    @Override
    public BorrowDocument borrow(BorrowRequest borrowRequest) {
        var borrowDocument = modelMapper.map(borrowRequest,BorrowDocument.class);
        var bookMicroServiceExistsByIdUrl = "http://localhost:9010/books/existsById/";
        var bookExistsResponse = restTemplate.getForEntity(bookMicroServiceExistsByIdUrl+borrowRequest.getBookId(),Boolean.class);
        if(bookExistsResponse.getBody().booleanValue()==true){
            if(borrowRequest.getUserType().equals("student")){
                var studentMicroServiceExistsByIdUrl="http://localhost:9000/books/existsById/";
                var studentResponse = restTemplate.getForEntity(studentMicroServiceExistsByIdUrl+borrowRequest.getUserId(),Boolean.class);
                if(studentResponse.getBody().booleanValue()==true){
                    return borrowMongoRepository.save(borrowDocument);
                }
            }
            if(borrowRequest.getUserType().equals("lecturer")){
                var lecturerMicroServiceExistsByIdUrl="http://localhost:8080/lecturers/existsById/";
                var lecturerResponse = restTemplate.getForEntity(lecturerMicroServiceExistsByIdUrl+borrowRequest.getUserId(),Boolean.class);
                System.err.println(lecturerResponse.getBody().booleanValue());
                if(lecturerResponse.getBody().booleanValue()==true){
                    return borrowMongoRepository.save(borrowDocument);
                }
            }
            if(borrowRequest.getUserType().equals("officer")){
                var studentMicroServiceExistsByIdUrl="http://localhost:9000/books/existsById/";
                var studentResponse = restTemplate.getForEntity(studentMicroServiceExistsByIdUrl+borrowRequest.getUserId(),Boolean.class);
                if(studentResponse.getBody().booleanValue()==true){
                    return borrowMongoRepository.save(borrowDocument);
                }
            }
            throw new IllegalArgumentException("kullanıcı bulunamadı");
        }
        throw new IllegalArgumentException("kitap bulunamadı");
    }
}
