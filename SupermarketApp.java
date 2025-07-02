import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class SupermarketApp {

    private static LinkedList<Product> productList = new LinkedList<>();
    private static Stack<Product> cartStack = new Stack<>();
    private static DefaultTableModel productTableModel;
    private static DefaultTableModel cartTableModel;

    private static HashMap<String, String> adminAccounts = new HashMap<>();
    private static HashMap<String, String> userAccounts = new HashMap<>();

    private static double totalPrice = 0.0;

    public static void main(String[] args) {
        adminAccounts.put("saad", "saad123");
        productList.add(new Product("apple(1KG bag)", "fruits", 200.00, 20));
        productList.add(new Product("oranges(1KG bag)", "fruits", 240.00, 20));
        productList.add(new Product("grapes(1KG bag)", "fruits", 300.00, 15));
        productList.add(new Product("bananas(1 dozen)", "fruits", 120.00, 15));
        productList.add(new Product("tomatoes(1KG bag)", "vegetable", 100.00, 20));
        productList.add(new Product("potatoes(1KG bag)", "vegetable", 120.00, 20));
        productList.add(new Product("onions(1KG bag)", "vegetable", 100.00, 20));
        productList.add(new Product("mint(100g bag)", "herbs", 50.00, 20));
        productList.add(new Product("coriander(100g bag)", "herbs", 50.00, 20));
        productList.add(new Product("whole chicken(1KG)", "meat", 600.00, 20));
        productList.add(new Product("Chicken breast(1KG)", "meat", 650.00, 20));
        productList.add(new Product("Chicken wings(1KG)", "meat", 550.00, 20));
        productList.add(new Product("beef(1KG)", "meat", 800.00, 20));
        productList.add(new Product("Mutton(1KG)", "meat", 650.00, 20));
        productList.add(new Product("salmon fish(1KG)", "meat", 1200.00, 20));
        productList.add(new Product("tuna fish(1KG)", "meat", 1550.00, 20));
        productList.add(new Product("Milk(1L)", "dairy", 220.00, 20));
        productList.add(new Product("yogurt(100g)", "dairy", 150.00, 20));
        productList.add(new Product("Cheese(100g)", "dairy", 200.00, 20));
        productList.add(new Product("Butter(200g)", "dairy", 250.00, 20));
        productList.add(new Product("Egg(1 dozen)", "dairy", 270.00, 20));
        productList.add(new Product("Bread", "dairy", 170.00, 20));
        productList.add(new Product("cakes", "dairy", 200.00, 20));
        productList.add(new Product("pastries", "dairy", 220.00, 20));
        productList.add(new Product("rice(1KG)", "pantry", 200.00, 20));
        productList.add(new Product("flour(1KG)", "pantry", 180.00, 20));
        productList.add(new Product("sugar(1KG)", "pantry", 160.00, 20));
        productList.add(new Product("salt(500g)", "pantry", 150.00, 20));
        productList.add(new Product("cooking oil(1KG)", "pantry", 200.00, 20));
        productList.add(new Product("pasta(1KG)", "pantry", 220.00, 20));
        productList.add(new Product("noodles", "pantry", 80.00, 20));
        productList.add(new Product("chips", "snacks", 100.00, 20));
        productList.add(new Product("nbiscuit", "snacks", 50.00, 20));
        productList.add(new Product("chocolates", "snacks", 100.00, 20));
        productList.add(new Product("candy", "snacks", 50.00, 20));
        productList.add(new Product("juices", "snacks", 120.00, 20));
        productList.add(new Product("cold drink", "snacks", 80.00, 20));
        productList.add(new Product("tea", "snacks", 110.00, 20));
        productList.add(new Product("soaps", "personal care", 150.00, 20));
        productList.add(new Product("shampoo", "personal care", 550.00, 20));
        productList.add(new Product("conditioners", "personal care", 150.00, 20));
        productList.add(new Product("toothpaste", "personal care", 250.00, 20));
        productList.add(new Product("toothbrush", "personal care", 150.00, 20));
        productList.add(new Product("deodarants", "personal care", 650.00, 20));
        productList.add(new Product("baby powder", "personal care", 450.00, 20));
        productList.add(new Product("tissues", "household", 200.00, 20));
        productList.add(new Product("detergents", "household", 270.00, 20));
        productList.add(new Product("spunges", "household", 100.00, 20));
        productList.add(new Product("battery", "household", 200.00, 20));
        productList.add(new Product("cells", "household", 40.00, 20));
        // Set default font for the application
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("PasswordField.font", new Font("Arial", Font.PLAIN, 14));
        UIManager.put("ComboBox.font", new Font("Arial", Font.PLAIN, 14));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        showLoginScreen();
    }

    private static void showLoginScreen() {
        JFrame loginFrame = new JFrame("BUYZAAR Login");
        loginFrame.setSize(500, 300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLayout(new BorderLayout());

        JLabel title = new JLabel("BUYZAAR", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        loginFrame.add(title, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(loginButton);
        inputPanel.add(signupButton);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        loginFrame.add(inputPanel, BorderLayout.CENTER);

        loginButton.addActionListener(
                e -> login(usernameField.getText(), new String(passwordField.getPassword()), loginFrame));
        signupButton.addActionListener(e -> showSignupScreen(loginFrame));

        loginFrame.setVisible(true);
    }

    private static void showSignupScreen(JFrame parentFrame) {
        parentFrame.dispose();

        JFrame signupFrame = new JFrame("Signup");
        signupFrame.setSize(500, 350);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupFrame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Signup for BUYZAAR", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        signupFrame.add(title, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JComboBox<String> roleSelector = new JComboBox<>(new String[] { "Admin", "User" });
        JButton signupButton = new JButton("Signup");
        JButton backButton = new JButton("Back");

        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(new JLabel("Role:"));
        inputPanel.add(roleSelector);
        inputPanel.add(signupButton);
        inputPanel.add(backButton);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        signupFrame.add(inputPanel, BorderLayout.CENTER);

        backButton.addActionListener(e -> {
            signupFrame.dispose();
            showLoginScreen();
        });

        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        signupFrame.add(inputPanel, BorderLayout.CENTER);

        signupButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String role = roleSelector.getSelectedItem().toString();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(signupFrame, "All fields are required.");
                return;
            }

            if (role.equals("Admin")) {
                if (adminAccounts.containsKey(username)) {
                    JOptionPane.showMessageDialog(signupFrame, "Admin username already exists.");
                } else {
                    adminAccounts.put(username, password);
                    JOptionPane.showMessageDialog(signupFrame, "Admin account created successfully.");
                    signupFrame.dispose();
                    showLoginScreen();
                }
            } else {
                if (userAccounts.containsKey(username)) {
                    JOptionPane.showMessageDialog(signupFrame, "User username already exists.");
                } else {
                    userAccounts.put(username, password);
                    JOptionPane.showMessageDialog(signupFrame, "User account created successfully.");
                    signupFrame.dispose();
                    showLoginScreen();
                }
            }
        });

        signupFrame.setVisible(true);
    }

    private static void login(String username, String password, JFrame loginFrame) {
        if (adminAccounts.containsKey(username) && adminAccounts.get(username).equals(password)) {
            loginFrame.dispose();
            showAdminUI();
        } else if (userAccounts.containsKey(username) && userAccounts.get(username).equals(password)) {
            loginFrame.dispose();
            showUserUI();
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Invalid username or password.");
        }
    }

    private static void showAdminUI() {
        JFrame adminFrame = new JFrame("Admin");
        adminFrame.setSize(700, 500);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setLayout(new BorderLayout());

        JLabel title = new JLabel("BUYZAAR - Bringing GOODNESS Home", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        adminFrame.add(title, BorderLayout.NORTH);

        // Panel for Product Table
        JPanel productPanel = new JPanel(new BorderLayout());
        productTableModel = new DefaultTableModel(new String[] { "Name", "Category", "Price", "Quantity" }, 0);
        JTable productTable = new JTable(productTableModel);

        JScrollPane scrollPane = new JScrollPane(productTable);
        productPanel.add(scrollPane, BorderLayout.CENTER);

        for (Product product : productList) {
            productTableModel.addRow(new Object[] { product.getName(), product.getCategory(), product.getPrice(),
                    product.getQuantity() });
        }

        // Bottom Panel (for control + search)
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Control Panel
        JPanel controlPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Row 1: Labels
        controlPanel.add(new JLabel("Name", JLabel.CENTER));
        controlPanel.add(new JLabel("Category", JLabel.CENTER));
        controlPanel.add(new JLabel("Price", JLabel.CENTER));
        controlPanel.add(new JLabel("Quantity", JLabel.CENTER));

        // Row 2: Input Fields
        JTextField nameField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();
        controlPanel.add(nameField);
        controlPanel.add(categoryField);
        controlPanel.add(priceField);
        controlPanel.add(quantityField);

        // Row 3: Buttons
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton logoutButton = new JButton("Logout");
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(new JLabel()); // Placeholder
        controlPanel.add(logoutButton);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(resetButton);

        // Add control and search panels to bottom panel
        bottomPanel.add(controlPanel, BorderLayout.NORTH);
        bottomPanel.add(searchPanel, BorderLayout.SOUTH);

        // Add components to frame
        adminFrame.add(productPanel, BorderLayout.CENTER);
        adminFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Button Logic
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String category = categoryField.getText().trim();
            double price;
            int quantity;

            try {
                price = Double.parseDouble(priceField.getText().trim());
                quantity = Integer.parseInt(quantityField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(adminFrame, "Invalid price or quantity.");
                return;
            }

            Product newProduct = new Product(name, category, price, quantity);
            productList.add(newProduct);
            productTableModel.addRow(new Object[] { name, category, price, quantity });

            nameField.setText("");
            categoryField.setText("");
            priceField.setText("");
            quantityField.setText("");
        });

        deleteButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                productList.remove(selectedRow);
                productTableModel.removeRow(selectedRow);
            }
        });

        logoutButton.addActionListener(e -> {
            adminFrame.dispose();
            showLoginScreen();
        });

        searchButton.addActionListener(e -> {
            String query = searchField.getText().trim().toLowerCase();
            productTableModel.setRowCount(0);
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(query)
                        || product.getCategory().toLowerCase().contains(query)) {
                    productTableModel.addRow(new Object[] { product.getName(), product.getCategory(),
                            product.getPrice(), product.getQuantity() });
                }
            }
        });

        resetButton.addActionListener(e -> {
            searchField.setText("");
            productTableModel.setRowCount(0);
            for (Product product : productList) {
                productTableModel.addRow(new Object[] { product.getName(), product.getCategory(), product.getPrice(),
                        product.getQuantity() });
            }
        });

        adminFrame.setVisible(true);
    }

    private static void showUserUI() {
        JFrame userFrame = new JFrame("SuperMarket");
        userFrame.setSize(700, 500);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLayout(new BorderLayout());

        JLabel title = new JLabel("BUYZAAR - Bring GOODNESS Home", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        userFrame.add(title, BorderLayout.NORTH);

        // Product Table
        JPanel productPanel = new JPanel(new BorderLayout());
        productTableModel = new DefaultTableModel(new String[] { "Name", "Category", "Price", "Quantity" }, 0);
        JTable productTable = new JTable(productTableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        productPanel.add(scrollPane, BorderLayout.CENTER);

        // Populate table
        for (Product product : productList) {
            productTableModel.addRow(new Object[] { product.getName(), product.getCategory(), product.getPrice(),
                    product.getQuantity() });
        }

        // --- Bottom panel combining control buttons and search ---
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Control buttons
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JButton addToCartButton = new JButton("Add to Cart");
        JButton viewCartButton = new JButton("View Cart");
        JButton logoutButton = new JButton("Logout");

        controlPanel.add(addToCartButton);
        controlPanel.add(viewCartButton);
        controlPanel.add(logoutButton);

        // Search section
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset");
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(resetButton);

        bottomPanel.add(controlPanel, BorderLayout.WEST);
        bottomPanel.add(searchPanel, BorderLayout.EAST);

        // --- Add to Cart Logic ---
        addToCartButton.addActionListener(e -> {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedName = (String) productTableModel.getValueAt(selectedRow, 0);

                // Find the actual product in the productList
                Product selectedProduct = null;
                for (Product p : productList) {
                    if (p.getName().equals(selectedName)) {
                        selectedProduct = p;
                        break;
                    }
                }

                if (selectedProduct == null) {
                    JOptionPane.showMessageDialog(userFrame, "Selected product not found.");
                    return;
                }

                if (selectedProduct.getQuantity() > 0) {
                    String quantityInput = JOptionPane.showInputDialog(userFrame,
                            "Enter quantity to add to cart (Available: " + selectedProduct.getQuantity() + "):",
                            "Add to Cart",
                            JOptionPane.QUESTION_MESSAGE);

                    if (quantityInput != null) {
                        try {
                            int quantity = Integer.parseInt(quantityInput.trim());
                            if (quantity <= 0) {
                                JOptionPane.showMessageDialog(userFrame, "Quantity must be greater than 0.");
                                return;
                            }

                            if (quantity > selectedProduct.getQuantity()) {
                                JOptionPane.showMessageDialog(userFrame, "Not enough stock available.");
                                return;
                            }

                            boolean exists = false;
                            for (Product cartProduct : cartStack) {
                                if (cartProduct.getName().equals(selectedProduct.getName())) {
                                    cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
                                    exists = true;
                                    break;
                                }
                            }

                            if (!exists) {
                                cartStack.push(new Product(selectedProduct.getName(), selectedProduct.getCategory(),
                                        selectedProduct.getPrice(), quantity));
                            }

                            selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);

                            // Refresh the table
                            productTableModel.setValueAt(selectedProduct.getQuantity(), selectedRow, 3);
                            JOptionPane.showMessageDialog(userFrame,
                                    quantity + " " + selectedProduct.getName() + "(s) added to cart!");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(userFrame, "Please enter a valid number.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(userFrame, "Product is out of stock!");
                }
            } else {
                JOptionPane.showMessageDialog(userFrame, "Please select a product to add to the cart.");
            }
        });

        viewCartButton.addActionListener(e -> showCartUI());

        logoutButton.addActionListener(e -> {
            userFrame.dispose();
            showLoginScreen();
        });

        // Search
        searchButton.addActionListener(e -> {
            String query = searchField.getText().trim().toLowerCase();
            productTableModel.setRowCount(0);
            for (Product product : productList) {
                if (product.getName().toLowerCase().contains(query) ||
                        product.getCategory().toLowerCase().contains(query)) {
                    productTableModel.addRow(new Object[] {
                            product.getName(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getQuantity()
                    });
                }
            }
        });

        resetButton.addActionListener(e -> {
            searchField.setText("");
            productTableModel.setRowCount(0);
            for (Product product : productList) {
                productTableModel.addRow(new Object[] {
                        product.getName(),
                        product.getCategory(),
                        product.getPrice(),
                        product.getQuantity()
                });
            }
        });

        // Final Layout Setup
        userFrame.add(title, BorderLayout.NORTH);
        userFrame.add(productPanel, BorderLayout.CENTER);
        userFrame.add(bottomPanel, BorderLayout.SOUTH);
        userFrame.setVisible(true);
    }

    private static void showCartUI() {
        JFrame cartFrame = new JFrame("Cart");
        cartFrame.setSize(500, 400);
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cartFrame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Your Cart", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        cartFrame.add(title, BorderLayout.NORTH);

        cartTableModel = new DefaultTableModel(new String[] { "Name", "Category", "Price", "Quantity" }, 0);
        JTable cartTable = new JTable(cartTableModel);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);
        cartFrame.add(cartScrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton deleteButton = new JButton("Delete");
        JButton checkoutButton = new JButton("Checkout");
        JButton backButton = new JButton("Back");

        controlPanel.add(deleteButton);
        controlPanel.add(checkoutButton);
        controlPanel.add(backButton);

        // Delete button logic
        deleteButton.addActionListener(e -> {
            int selectedRow = cartTable.getSelectedRow();
            if (selectedRow != -1) {
                String productName = (String) cartTableModel.getValueAt(selectedRow, 0);

                // Find the product in the cart and remove it
                Product productToRemove = null;
                for (Product cartProduct : cartStack) {
                    if (cartProduct.getName().equals(productName)) {
                        productToRemove = cartProduct;
                        break;
                    }
                }

                if (productToRemove != null) {
                    cartStack.remove(productToRemove);

                    // Return quantity to the product list
                    for (Product product : productList) {
                        if (product.getName().equals(productName)) {
                            product.setQuantity(product.getQuantity() + productToRemove.getQuantity());
                            break;
                        }
                    }

                    // Remove from cart table
                    cartTableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(cartFrame, "Item removed from cart.");
                }
            } else {
                JOptionPane.showMessageDialog(cartFrame, "No item selected.");
            }
        });

        // Checkout button logic
        checkoutButton.addActionListener(e -> checkout(cartFrame));

        // Back button logic
        backButton.addActionListener(e -> cartFrame.dispose());

        // Populate cart table
        cartTableModel.setRowCount(0);
        for (Product product : cartStack) {
            cartTableModel.addRow(new Object[] { product.getName(), product.getCategory(), product.getPrice(),
                    product.getQuantity() });
        }

        cartFrame.add(controlPanel, BorderLayout.SOUTH);
        cartFrame.setVisible(true);
    }

    private static void checkout(JFrame cartFrame) {
        if (!cartStack.isEmpty()) {
            double totalAmount = 0.0;
            StringBuilder receipt = new StringBuilder("Receipt:\n\n");

            // Calculate total amount based on quantity
            for (Product product : cartStack) {
                totalAmount += product.getPrice() * product.getQuantity();
                receipt.append(product.getName()).append(" - ").append(product.getPrice()).append(" x ")
                        .append(product.getQuantity()).append("\n");
            }

            receipt.append("\nTotal Amount: ").append(totalAmount);

            JOptionPane.showMessageDialog(cartFrame, receipt.toString(), "Checkout Successful",
                    JOptionPane.INFORMATION_MESSAGE);
            cartTableModel.setRowCount(0);
            cartStack.clear(); // Clear the cart after checkout
        } else {
            JOptionPane.showMessageDialog(cartFrame, "Cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class Product {
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
