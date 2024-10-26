package com.contact.service.Impl;

import com.contact.entity.Contact;
import com.contact.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    //fake list of contacts
    //fake list of contacts
    List<Contact> list = List.of(
            new Contact(1L, "amit@gmail.com", "Amit", 1314L),
            new Contact(2L, "anil@gmail.com", "Anil", 1314L),
            new Contact(3L, "chauhan@gmail.com", "Chauhan", 1311L),
            new Contact(4L, "john.doe@gmail.com", "John Doe", 1312L),
            new Contact(5L, "jane.doe@gmail.com", "Jane Doe", 1313L),
            new Contact(6L, "alice@gmail.com", "Alice", 1314L),
            new Contact(7L, "bob@gmail.com", "Bob", 1311L),
            new Contact(8L, "charlie@gmail.com", "Charlie", 1311L),
            new Contact(9L, "david@gmail.com", "David", 1312L),
            new Contact(10L, "eve@gmail.com", "Eve", 1313L)
    );
    @Override
    public List<Contact> getContactOfUser(Long userId) {
        return list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
