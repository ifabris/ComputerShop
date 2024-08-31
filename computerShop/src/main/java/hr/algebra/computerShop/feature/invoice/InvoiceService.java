package hr.algebra.computerShop.feature.invoice;


import java.util.List;

public interface InvoiceService {
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(int id);
    Invoice saveInvoice(Invoice invoice);
    void deleteInvoice(int id);
}
