from Bio import SeqIO

# Input and output FASTA file paths
input_file = "highlight.fasta"
output_file = "filtered.fasta"

# Filter sequences longer than 100 bases
filtered_records = (record for record in SeqIO.parse(input_file, "fasta") if len(record.seq) > 100)

# Write filtered sequences to a new FASTA file
SeqIO.write(filtered_records, output_file, "fasta")
print(f"Filtered sequences saved to {output_file}")
