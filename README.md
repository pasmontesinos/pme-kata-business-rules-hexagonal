[Kata16: Business Rules](http://codekata.com/kata/kata16-business-rules/)

How can you tame a wild (and changing) set of business rules?

Imagine you’re writing an order processing application for a large company. In the past, this company used a fairly random mixture of manual and ad-hoc automated business practices to handle orders; they now want to put all these various ways of hanadling orders together into one whole: your application. However, they (and their customers) have come to cherish the diversity of their business rules, and so they tell you that you’ll have to bring all these rules forward into the new system.

When you go in to meet the existing order entry folks, you discover that their business practices border on chaotic: no two product lines have the same set of processing rules. To make it worse, most of the rules aren’t written down: you’re often told something like “oh, Carol on the second floor handles that kind of order.”

During first day of meetings, you’ve decided to focus on payments, and in particular on the processing required when a payment was received by the company. You come home, exhausted, with a legal pad full of rule snippets such as:

- If the payment is for a physical product, generate a packing slip for shipping.
- If the payment is for a book, create a duplicate packing slip for the royalty department.

