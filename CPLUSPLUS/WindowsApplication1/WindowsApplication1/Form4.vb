Public Class Form4

    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        Me.Hide()
        Dim form1 As New Form1()
        form1.Show()
    End Sub

    Private Sub Form4_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Form1.Close()
        Form2.Close()
        Form3.Close()
        Form5.Close()
    End Sub
End Class